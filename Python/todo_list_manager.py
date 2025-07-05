class Task:
    def __init__(self, description):
        self.description = description
        self.completed = False

    def mark_done(self):
        self.completed = True

    def __str__(self):
        status = '✔' if self.completed else '✖'
        return f"({status}) {self.description}"


class TodoList:
    def __init__(self):
        self.tasks = []

    def add_tasks(self, *descriptions):
        for des in descriptions:
            self.tasks.append(Task(des))

    def mark_tasks_done(self, *indexes):
        for i in indexes:
            self.tasks[i - 1].mark_done()

    def remove_task(self, index):
        if 1 <= index <= len(self.tasks):
            del self.tasks[index - 1]
        else:
            raise IndexError("Invalid task number.")

    def search(self, keyword):
        found = False
        print(f"Search results for '{keyword}':")
        for i, task in enumerate(self.tasks):
            if keyword.lower() in task.description.lower():
                print(f"{i + 1}. {task}")
                found = True
        if not found:
            print("* No results found!")

    def sort_tasks(self, by="status"):
        if by == "alpha":
            self.tasks.sort(key=lambda task: task.description.lower())
        elif by == "status":
            self.tasks.sort(key=lambda task: task.completed)

    def show_tasks(self):
        print("To-Do List")
        print("----------")
        for i, task in enumerate(self.tasks):
            print(f"{i + 1}. {task}")





todo = TodoList()

todo.add_tasks("Get up", "Brush teeth", "Eat breakfast", "Go to gym", "Take shower")
todo.mark_tasks_done(1, 3, 5)
todo.sort_tasks()

todo.show_tasks()