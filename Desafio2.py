# gets the number of divisers of a given number
def getNofDivisers(number):
    retval = 0
    for i in range(1, number+1):
        if (number % i == 0):
            retval += 1
    return retval


def main():
    numbers = input("Input: ").split(" ")

    # validation of input
    while(len(numbers) != 2 or not numbers[0].isdigit() or not numbers[1].isdigit() or int(numbers[0]) < 1 or int(numbers[1]) > 100):
        print("ERROR: bad input")
        numbers = input("Input: ").split(" ")
    nMin = int(numbers[0])
    nMax = int(numbers[1])
    nOfDivisers = 0

    # goes through all numbers and if it's number of divisors is even sums 1 to the total number of divisers
    for i in range(nMin, nMax+1):
        if(getNofDivisers(i) % 2 == 0):
            nOfDivisers += 1
    print(nOfDivisers)


if __name__ == "__main__":
    # execute only if run as a script
    main()
