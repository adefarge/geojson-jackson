package io.jawg.geojson.serializer

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.jawg.geojson.Position
import org.junit.Test
import kotlin.test.assertEquals

class PositionSerializerTest {

  private val mapper = ObjectMapper().registerModule(KotlinModule())

  @Test
  fun `it should serialize to (lng, lat)`() {
    val position = Position(
        lng = 1.1,
        lat = 2.2
    )

    val geojson = mapper.writeValueAsString(position)

    val expected = """
      [1.1, 2.2]
    """.replace("\\s".toRegex(), "")

    assertEquals(expected, geojson)
  }

  @Test
  fun `it should serialize to (lng, lat, alt)`() {
    val position = Position(
        lng = 1.1,
        lat = 2.2,
        alt = 3.3
    )

    val geojson = mapper.writeValueAsString(position)

    val expected = """
      [1.1, 2.2, 3.3]
    """.replace("\\s".toRegex(), "")

    assertEquals(expected, geojson)
  }

}