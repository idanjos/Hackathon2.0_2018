def main():
    print("Input:")
    nWords = input()
    while(not nWords.isdigit()):
        print("ERROR: Bad Input!")
        nWords = input()
    nWords = int(nWords)
    listOfWords = input().split(" ")
    while(len(listOfWords) != nWords):
        print("ERROR: Bad input!")
        listOfWords = input().split(" ")
    resultCharArray = []

    # for loop to get the 3 smallest chars
    for word in listOfWords:
        smallestChar = ""
        first = 1
        for char in word:
            if first == 1:  # if first iteration define first char as the smallest char
                smallestChar = char
                first = 0
            else:   # in the other iterations verify the smaller char and update value
                if char < smallestChar:
                    smallestChar = char
        resultCharArray += smallestChar   # add smallest char of that word to char array
    resultStr = ""

    # for loop to construt string in its smallest form
    for char in sorted(resultCharArray):
        resultStr += char

    print("Output: " + resultStr)


if __name__ == "__main__":
    # execute only if run as a script
    main()
