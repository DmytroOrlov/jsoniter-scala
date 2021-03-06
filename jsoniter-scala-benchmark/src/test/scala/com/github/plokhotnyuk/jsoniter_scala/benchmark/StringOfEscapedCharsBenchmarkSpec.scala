package com.github.plokhotnyuk.jsoniter_scala.benchmark

class StringOfEscapedCharsBenchmarkSpec extends BenchmarkSpecBase {
  private val benchmark = new StringOfEscapedCharsBenchmark {
    setup()
  }

  "StringOfEscapedCharsBenchmark" should {
    "deserialize properly" in {
      benchmark.readAVSystemGenCodec() shouldBe benchmark.obj
      benchmark.readCirce() shouldBe benchmark.obj
      benchmark.readDslJsonJava() shouldBe benchmark.obj
      benchmark.readJacksonScala() shouldBe benchmark.obj
      benchmark.readJsoniterJava() shouldBe benchmark.obj
      benchmark.readJsoniterScala() shouldBe benchmark.obj
      benchmark.readPlayJson() shouldBe benchmark.obj
      benchmark.readUPickle() shouldBe benchmark.obj
    }
    "serialize properly" in {
      toString(benchmark.writeAVSystemGenCodec()) shouldBe benchmark.jsonString
      toString(benchmark.writeCirce()) shouldBe benchmark.jsonString
      // FIXME: DSL-JSON doesn't support escaping of non-ASCII characters
      //toString(benchmark.writeDslJsonJava()) shouldBe benchmark.jsonString
      toString(benchmark.writeJacksonScala()) shouldBe benchmark.jsonString2
      // FIXME: Jsoniter Java cannot restore config properly
      //toString(benchmark.writeJsoniterJava()) shouldBe benchmark.jsonString
      toString(benchmark.writeJsoniterScala()) shouldBe benchmark.jsonString
      toString(benchmark.preallocatedBuf, 0, benchmark.writeJsoniterScalaPrealloc()) shouldBe benchmark.jsonString
      toString(benchmark.writePlayJson()) shouldBe benchmark.jsonString2
      toString(benchmark.writeUPickle()) shouldBe benchmark.jsonString
    }
  }
}