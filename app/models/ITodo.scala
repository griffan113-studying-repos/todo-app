package models

import java.time.LocalDateTime
import java.util.UUID

trait ITodo {
  var id: UUID
  var title: String
  var content: String
  var isCompleted: Boolean = false
  var createdAt: LocalDateTime
}
