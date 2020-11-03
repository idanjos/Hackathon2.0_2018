def main():
    string = input("Input: ")
    length = len(string)
    numberOfPalindromes = 0
    # start in index zero and go through all string until last char (excluded)
    for i in range(0, length):
        for j in range(i+1, length+1):
            word = string[i:j]  # get substring
            if word == word[::-1]:  # check if it is palindrome, increment if it is
                numberOfPalindromes += 1
    print("Output:", numberOfPalindromes)


if __name__ == "__main__":
    # execute only if run as a script
    main()
