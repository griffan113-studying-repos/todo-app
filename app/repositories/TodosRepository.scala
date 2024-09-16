package repositories

import models.ITodosRepository
import models.ITodo
import dtos.CreateTodoDto
import entities.Todo

class TodosRepository extends ITodosRepository {
  private var todos: List[Todo] = List()

  override def list(): List[Todo] = this.todos

  override def create(data: CreateTodoDto): Todo = {
    val newTodo = new Todo(
      java.util.UUID.randomUUID(),
      data.title,
      data.content,
      java.time.LocalDateTime.now()
    )

    // :+ = This is used to append
    // :: = This is used to prepend
    todos = todos :+ newTodo

    newTodo
  }
}
