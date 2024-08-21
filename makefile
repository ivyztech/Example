all: main test

main: main.cpp
	g++ -o main main.cpp

test: test.cpp
	g++ -o test test.cpp

clean:
	rm -f main test
