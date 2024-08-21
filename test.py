import main

def test_greet():
    assert main.greet("World") == "Hello, World!"
    assert main.greet("Jenkins") == "Hello, Jenkins!"
    print("All tests passed!")

if __name__ == "__main__":
    test_greet()
