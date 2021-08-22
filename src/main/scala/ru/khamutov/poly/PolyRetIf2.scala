package ru.khamutov.poly

import org.bson.{BsonDocument, BsonDocumentReader}

class PolyRetIf2 {
  def readString(document: BsonDocument): String = {
    val reader = readStartDoc(document)
    val value = reader.readString()
    readEndDoc(reader)

    value
  }

  def readInt(document: BsonDocument): Int = {
    val reader = readStartDoc(document)
    val value = reader.readInt32()
    readEndDoc(reader)

    value
  }

  def readStartDoc(document: BsonDocument): BsonDocumentReader = {
    val reader = new BsonDocumentReader(document)

    reader.readStartDocument()
    reader.readName("_id")
    reader.readString()
    reader.readName("value")
    reader
  }

  def readEndDoc(reader: BsonDocumentReader): BsonDocumentReader = {
    reader.readEndDocument()
    reader
  }
}
