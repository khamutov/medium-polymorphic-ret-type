package ru.khamutov.poly

import org.bson.{BsonDocument, BsonDocumentReader}

class PolyRetIf {
  def readString(document: BsonDocument): String = {
    val reader = new BsonDocumentReader(document)

    reader.readStartDocument()
    reader.readName("_id")
    reader.readString()
    reader.readName("value")
    val value = reader.readString()
    reader.readEndDocument()

    value
  }

  def readInt(document: BsonDocument): Int = {
    val reader = new BsonDocumentReader(document)

    reader.readStartDocument()
    reader.readName("_id")
    reader.readString()
    reader.readName("value")
    val value = reader.readInt32()
    reader.readEndDocument()

    value
  }
}
