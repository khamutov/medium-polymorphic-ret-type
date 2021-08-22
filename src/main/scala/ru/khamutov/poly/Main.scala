package ru.khamutov.poly

import org.bson.BsonDocumentWriter
import org.mongodb.scala.bson.BsonDocument

object Main extends App {

  override def main(args: Array[String]): Unit = {
    val writerString = new BsonDocumentWriter(new BsonDocument())
    writerString.writeStartDocument()
    writerString.writeName("_id")
    writerString.writeString("id")
    writerString.writeName("value")
    writerString.writeString("test")
    writerString.writeEndDocument()
    val docString = writerString.getDocument

    val writerInt = new BsonDocumentWriter(new BsonDocument())
    writerInt.writeStartDocument()
    writerInt.writeName("_id")
    writerInt.writeString("id")
    writerInt.writeName("value")
    writerInt.writeInt32(42)
    writerInt.writeEndDocument()
    val docInt = writerInt.getDocument

    import Codecs._
    val reading = new PolyRetIf4()
    println(reading.read[String](docString))
    println(reading.read[String](docString).getClass)
    println(reading.read[Int](docInt))
    println(reading.read[Int](docInt).getClass)
  }
}
