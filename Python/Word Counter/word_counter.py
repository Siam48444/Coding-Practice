import string


def get_word_count(filename: str) -> dict:
	try:
		with open(filename, "r") as file:
			content = file.read()
			words = content.split()
			table = str.maketrans("", "", string.punctuation)
			cleaned_words = [w.lower().translate(table) for w in words]

		count = {}
		for word in cleaned_words:
			count[word] = count.get(word, 0) + 1
		return count

	except FileNotFoundError:
		print(f"Error: The file '{filename}' was not found.")
		return {}



filename = "input.txt"
word_count = get_word_count(filename)

if word_count:
	sorted_words = sorted(word_count.items(), key=lambda x: x[1], reverse=True)
	with open("output.txt", "w") as file:
		file.write(f"Word count for the file: '{filename}'\n")
		file.write("--------------------------------------\n")
		for word, freq in sorted_words:
			file.write(f"{word:<30} : {freq}\n")