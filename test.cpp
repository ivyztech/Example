#include "main.cpp"
#include <cassert>
#include <iostream>

void test_greet() {
    assert(greet("World") == "Hello, World!");
    assert(greet("Jenkins") == "Hello, Jenkins!");
    std::cout << "All tests passed!" << std::endl;
}

int main() {
    test_greet();
    return 0;
}
