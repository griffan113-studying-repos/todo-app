package dtos

case class CreateTodoDto(
    var title: String,
    var content: String,
    var isCompleted: Boolean = false
)
