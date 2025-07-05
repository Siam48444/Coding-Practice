import string


banned_file = "banned.txt"
secret_file = "secret.txt"
redacted_file = "redacted.txt"

try:
	with open(banned_file, "r") as file:
		banned_words = [line.lower().strip() for line in file]
except FileNotFoundError:
	print(f"❌ No file was found called '{banned_file}'.")
	banned_words = []

try:
	with open(secret_file, "r") as file:
		content = file.read()
except FileNotFoundError:
	print(f"❌ No file was found called '{secret_file}'.")
	content = None


words = content.split() if content else exit()
cleaned = []
redacted_text = ""

for word in words:
	suffix = ""

	if word[-1] in string.punctuation:
		suffix = word[-1]
		core = word[:-1]
	else:
		core = word

	if core.lower() in banned_words:
		redacted = "_" * len(core)
	else:
		redacted = core

	cleaned.append(redacted + suffix)

redacted_text = " ".join(cleaned)


with open(redacted_file, "w") as file:
	file.write(redacted_text)
	print(f"✅ Redacted content written to '{redacted_file}'.")