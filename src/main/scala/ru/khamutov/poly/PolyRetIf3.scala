package ru.khamutov.poly

import org.bson.{BsonDocument, BsonDocumentReader}

class PolyRetIf3 {
  def readString(document: BsonDocument): String = {
    readDocument(document, reader => reader.readString())
  }

  def readInt(document: BsonDocument): Int = {
    readDocument(document, reader => reader.readInt32())
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
