package models

import dtos.CreateTodoDto

trait ITodosRepository {
  def list(): List[ITodo]

  def create(data: CreateTodoDto): ITodo
}
