package ru.khamutov.poly

import org.bson.{BsonDocument, BsonDocumentReader}

class PolyRet {
  private val value: String = "10"

//  def get[T](document: BsonDocument): T = {
//    val reader = new BsonDocumentReader(document)
//
//    reader.readStartDocument()
//    reader.readName("value")
////    val decodedValue = codec.decode(reader, DecoderContext.builder().build())
//    reader.readEndDocument()
//
////    decodedValue
//  }
}
