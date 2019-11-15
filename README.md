# springboot-customactuator-example
An example of implementing a custom actuator endpoint in Spring Boot.

## Building the Example
Run the following command to build the example:

    ./gradlew clean build
    
### Docker
Run the following command to build the example application as a Docker image:

    ./gradlew clean buildImage
    
## Running the Example
Follow the steps below to run the example:

1. Start the application:

    If executing the application via Gradle, run the following command:

        ./gradlew bootRun
        
    If executing the application via Docker, run the following command:
    
        docker run -p 8080:8080 gregnetifi/springboot-customactuator-example
        
2. Run the following command several times to create some notes:

        curl -d '{"title":"Test Note", "text":"This is some test note."}' -H "Content-Type: application/json" -X POST http://localhost:8080/notes

3. Run the following command to retrieve the total count of notes via the actuator endpoint:

        curl http://localhost:8080/actuator/notes/count
        
    If successful, you will see the count returned as follows:
    
        {"note_count":3}

4. Run the following command to clear all stored notes via the actuator endpoint:

        curl -X DELETE http://localhost:8080/actuator/notes
        
5. Finally, verify that the notes repository was cleared by running the following command again:

        curl http://localhost:8080/actuator/notes/count
        
    If successful, you will see that the note repository is now empty:

        {"note_count":0}

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/springboot-customactuator-example/issues).

## License
MIT License

Copyright (c) 2019 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.