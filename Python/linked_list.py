class Node:
	def __init__(self, value):
		self.value = value
		self.next = None


class LinkedList: 
	def __init__(self):
		self.head = None


	def push_front(self, value):
		'''Adds a new node with the given value at the start of the linked list'''
		new_node = Node(value)
		new_node.next = self.head
		self.head = new_node


	def push_back(self, value):
		'''Adds a new node with the given value at the end of the linked list'''
		new_node = Node(value)
		if not self.head:
			self.head = new_node
		elif not self.head.next:
			self.head.next = new_node
		else:
			current = self.head
			while current.next:
				current = current.next
			current.next = new_node


	def pop_front(self):
		'''Removes and returns the first element of the linked list'''
		if not self.head:
			raise IndexError("Can't pop from an empty list.")

		first = self.head
		self.head = self.head.next
		return first.value


	def pop_back(self):
		'''Removes and returns the last element of the linked list'''
		if not self.head:
			raise IndexError("Can't pop from an empty list.")
		elif not self.head.next:
			last = self.head
			self.head = None
			return last.value
		else:
			current = self.head
			while current.next.next:
				current = current.next
			last = current.next
			current.next = None
			return last.value


	def reverse(self):
		'''Reverses the current linked list'''
		current = self.head
		prev = None
		while current:
			next_node = current.next
			current.next = prev
			prev = current
			current = next_node
		self.head = prev


	def reversed(self):
		'''Returns the reversed version of the linked list'''
		new_list = LinkedList()
		current = self.head
		while current:
			new_list.push_front(current.value)
			current = current.next
		return new_list


	def copy(self):
		'''Returns the exact copy of the linked list'''
		new_list = LinkedList()
		current = self.head
		while current:
			new_list.push_back(current.value)
			current = current.next
		return new_list


	def length(self):
		'''Returns the length of the linked list'''
		current = self.head
		count = 0
		while current:
			current = current.next
			count += 1
		return count


	def middle(self):
		'''Returns the middle value. If even-sized, returns the second middle.'''
		if not self.head:
			raise IndexError("List is empty.")
		elif not self.head.next:
			return self.head.value
		else:
			slow = fast = self.head
			while fast and fast.next:
				fast = fast.next.next
				slow = slow.next
			return slow.value


	def delete(self, index):
		'''Deletes the node at the specified index'''
		if index < 0 or index >= self.length():
			raise IndexError("Index out of range!")

		if index == 0:
			self.head = self.head.next
			return
		else:
			current = self.head
			count = 1
			while current.next and count < index:
				current = current.next
				count += 1
			current.next = current.next.next


	def insert(self, index, value):
		'''Inserts a new node with the given value at the specified index'''
		if index < 0 or index > self.length():
			raise IndexError("Index out of range!")

		new_node = Node(value)
		if index == 0:
			self.push_front(new_node.value)
			return
		elif index == self.length():
			self.push_back(new_node.value)
			return
		else:
			current = self.head
			count = 1
			while current and count < index:
				count += 1
				current = current.next
			new_node.next = current.next
			current.next = new_node


	def get(self, index):
		'''Retrieves the value of the node at the specified index'''
		if index < 0 or index >= self.length():
			raise IndexError("Index out of range!")

		current = self.head
		count = 0
		while current:
			if count == index:
				return current.value
			count += 1
			current = current.next


	def make_cycle(self, index):
		'''Makes the last node point to the node at the given index'''
		if not self.head:
			raise Exception("List is empty!")

		if index < 0 or index >= self.length():
			raise IndexError("Index out of range!")

		target = self.head
		for _ in range(index):
			target = target.next

		tail = self.head
		while tail.next:
			tail = tail.next

		tail.next = target


	def detect_cycle(self):
		'''Detects if the linked list has a cycle'''
		if not self.head:
			raise Exception("List is empty.")

		slow = fast = self.head
		while fast and fast.next:
			fast = fast.next.next
			slow = slow.next
			if slow == fast:
				return True
		return False


	def find_cycle_node(self):
		'''Returns the node where the cycle begins, or None if there is no cycle.'''
		slow = fast = self.head
		is_cycle = False

		while fast and fast.next:
			fast = fast.next.next
			slow = slow.next
			if slow == fast:
				is_cycle = True
				break

		if is_cycle:
			slow = self.head
			while slow != fast:
				slow = slow.next
				fast = fast.next
			return slow
		else:
			return None


	def remove_cycle(self):
		'''Removes the cycle in the linked list (if any)'''
		cycle_start = self.find_cycle_node()
		if not cycle_start:
			return
		else:
			pointer = cycle_start
			while pointer.next != cycle_start:
				pointer = pointer.next
			pointer.next = None


	def swap_pairs(self):
		'''Swap each pair in the linked list'''
		if not self.head or not self.head.next:
			return self.head

		prev = None
		first = self.head
		second = first.next

		while first and second:
			third = second.next

			second.next = first
			first.next = third

			if prev:
				prev.next = second
			else:
				self.head = second

			prev = first
			first = third
			second = third.next if third else None


	def make_list(self):
		'''Converts the linked list into a Python list of values'''
		result = []
		current = self.head
		while current:
			result.append(current.value)
			current = current.next
		return result


	def display(self, show_arrows=True):
		'''Prints all node values in the linked list in order'''
		current = self.head
		while current:
			end = f"{' -> ' if show_arrows else ', '}" if current.next else "\n"
			print(current.value, end=end)
			current = current.next





ll = LinkedList()

for i in range(10):
	ll.push_back(i+1)

ll.display()
