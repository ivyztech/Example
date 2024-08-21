#include <iostream>
#include <string>

std::string greet(const std::string& name) {
    return "Hello, " + name + "!";
}

int main() {
    std::string user_name;
    std::cout << "Enter your name: ";
    std::cin >> user_name;
    std::cout << greet(user_name) << std::endl;
    return 0;
}
