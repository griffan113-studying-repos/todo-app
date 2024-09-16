package services

import javax.inject._
import play.api.libs.json._
import repositories.TodosRepository
import entities.Todo
import models.ITodo
import dtos.CreateTodoDto

@Singleton
class ListAllTodosService @Inject() (
    todosRepository: TodosRepository
) {
  def execute(): List[Todo] = {
    todosRepository.create(CreateTodoDto("Hello", "World"))
    todosRepository.create(
      CreateTodoDto("Add SQL", "Add relational database ORM")
    )

    val todos = todosRepository.list()

    todos
  }
}
