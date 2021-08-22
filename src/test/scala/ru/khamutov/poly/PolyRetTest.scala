package ru.khamutov.poly

import org.bson.BsonDocumentWriter
import org.mongodb.scala.bson.BsonDocument
import org.scalatest.FunSpec

class PolyRetTest extends FunSpec {

  it("construct bson doc") {
    val writer = new BsonDocumentWriter(new BsonDocument())

    writer.writeStartDocument()
    writer.writeName("name")
    writer.writeString("test")
    writer.writeEndDocument()
    val doc = writer.getDocument
  }
}
