package ru.khamutov.poly

import org.bson.codecs.Codec
import org.bson.{BsonDocument, BsonDocumentReader}

trait ReadCodec[T] {
  @inline
  def read(reader: BsonDocumentReader): T
}

object Codecs {
  implicit object ReadCodecString extends ReadCodec[String] {
    override def read(reader: BsonDocumentReader): String = reader.readString()
  }

  implicit object ReadCodecInt extends ReadCodec[Int] {
    override def read(reader: BsonDocumentReader): Int = reader.readInt32()
  }
}


class PolyRetIf4 {
  def read[T](document: BsonDocument)(implicit codec: ReadCodec[T]) : T = {
    readDocument(document, codec.read)
  }

  def readDocument[T](document: BsonDocument, readFn: BsonDocumentReader => T): T = {
    val reader = new BsonDocumentReader(document)

    reader.readStartDocument()
    reader.readName("_id")
    reader.readString()
    reader.readName("value")
    val value = readFn(reader)
    reader.readEndDocument()

    value
  }
}
