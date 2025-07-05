class Bank:
	bank_name = "City Bank"
	__total_accounts = 0
	__accounts = dict()


	def __init__(self, name, balance=0):
		self.name = name
		self.__balance = balance
		self.__history = list()
		self.__class__.__total_accounts += 1
		self.__class__.__accounts[f"{self.name}"] = self.__balance


	@property
	def balance(self):
		# Return formatted balance info
		return self.__balance


	@classmethod
	def show_accounts_details(cls):
		# Show all the accounts with names and balances
		line_length = 45
		line = "-" * line_length

		print("==> All the bank accounts (Name and Balance):")
		print(line)
		for name, bal in cls.__accounts.items():
			print(f"{name:<{line_length // 2 - len(str(name)) + 2}} | {bal:>{line_length // 2 - len(str(bal)) + 3}}")
		print(line)
  

	@classmethod
	def show_total_accounts(cls):
		# Shows the total number of accounts
		print(f"Total accounts in '{cls.bank_name}' = {cls.__total_accounts}")


	@staticmethod
	def is_valid_amount(amount):
		return isinstance(amount, (int, float)) and amount > 0


	def deposit(self, amount):
		# Add money to account
		if not self.__class__.is_valid_amount(amount):
			print("Error: Invalid deposit amount!")
		else:
			self.__balance += amount
			self.__history.append(f"Deposited   : ${amount:.2f}")
			self.__class__.__accounts[f"{self.name}"] = self.__balance


	def withdraw(self, amount):
		# Subtract money if enough balance
		if not self.__class__.is_valid_amount(amount):
			print("Error: Invalid withdraw amount!")
		elif self.__balance < amount:
			print(f"Error: Insufficient balance! Cannot withdraw ${amount:.2f}")
		else:
			self.__balance -= amount
			self.__history.append(f"Withdrew    : ${amount:.2f}")
			self.__class__.__accounts[f"{self.name}"] = self.__balance


	def transfer(self, other, amount):
		# Send money to another account
		if not self.__class__.is_valid_amount(amount):
			print("Error: Invalid transfer amount!")
		elif self.__balance < amount:
			print(f"Error: Insufficient balance! Cannot transfer ${amount:.2f}")
		else:
			other.__balance += amount
			self.__balance -= amount
			self.__history.append(f"Transferred : ${amount:.2f}  (to {other.name})")
			other.__history.append(f"Received    : ${amount:.2f}  (from {self.name})")
			self.__class__.__accounts[f"{self.name}"] = self.__balance


	def show_history(self):
		print(f"History of {self.name}:")
		for entry in self.__history:
			print(f"   -> {entry}")


	def __str__(self):
		# Display account summary
		return f"{self.name} has ${self.__balance:.2f} in the '{self.__class__.bank_name}'."




tony = Bank("Tony", 5000)
joel = Bank("Joel", 2000)

tony.deposit(100)
tony.transfer(joel, 4000)
joel.withdraw(500)

print(tony)
print(joel)

tony.show_history()
joel.show_history()

Bank.show_accounts_details()