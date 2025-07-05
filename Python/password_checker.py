from termcolor import colored, cprint


class PasswordChecker:
    def __init__(self, password):
        self.__password = password

    def check_strength(self):
        if self.is_common():
            return colored("Very weak!", "red")
        if (
            len(self.__password) >= 12 and
            any(char.isdigit() for char in self.__password) and
            any(not char.isalnum() for char in self.__password) and
            any(char.islower() for char in self.__password) and
            any(char.isupper() for char in self.__password)
        ):
            return colored("Strong", "green")
        elif len(self.__password) >= 8 and any(char.isdigit() for char in self.__password):
            return colored("Moderate", "blue")
        else:
            return colored("Weak", "red")

    def is_common(self):
        common_passwords = ["123456", "password", "admin", "qwerty"]
        return self.__password.lower() in common_passwords

    def __str__(self):
        return f"Password strength: {self.check_strength()}"



user_input = "Siam_1618"
checker = PasswordChecker(user_input)
print(checker)