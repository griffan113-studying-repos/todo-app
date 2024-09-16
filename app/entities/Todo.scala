package entities

import models.ITodo
import java.util.UUID
import java.time.LocalDateTime

final case class Todo(
    var id: UUID,
    var title: String,
    var content: String,
    var createdAt: LocalDateTime
) extends ITodo {}
