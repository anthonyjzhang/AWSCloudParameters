<h1> CST-AWSCloudParameters Project </h1> 

A web application that retrieves and filters parameters in Cell Signaling Technology's AWS account. 

<h2> 📄 Summary </h2> 

This project was a part of my internship for Cell Singaling Technologies (CST). At CST, I studied under CST's Director of Software Engineering. I first learned how CST leverages Amazon Web Services (AWS) to manage and build their digital infrastructure. I earned the AWS Certified Cloud Practitioner Certification and gained hands-on experience with foundational AWS services such as EC2, S3, VPCs, Systems Manager, IAM, Lambda, and more. The purpose of this project is to retrieve and filter parameters stored in Parameter Store in AWS Systems Managager. My code first securely authenticates an AWS account using an AWS access key and secret key. Note that these credentials are not hard coded into the program, as this would not be secure. Then, the program sets the AWS region and makes a request to AWS Systems Manager Parameter Store. The program implements three API functions. The first function, listParameters, lists all of the parameters in the associated AWS account's Parameter Store. The second function, listKeys, has a parameter (String prefix). This function lists all of the parameters in the associated AWS account's Parameter Store that contain the input prefix, allowing you to filter parameters by environment, owner, and other identifiers. The third function, getParameter, has a parameter (String key), which allows you to retrieve the value of the parameter associated with the input key in the associated AWS account's Parameter Store. Each function returns HTTP status responses. Status code 100 for a valid request, status code 400 for a bad request, and status code 500 for a server error. 

<h2> 💻 Softwares and Technologies </h2> 

This project (programmed in Java) uses Maven to build the code and utilizes the Spring Framework (Spring Boot). These technologies are essential to allowing the application to run. Maven converts the API specifications written in OpenAPI to source code. Spring Boot helps manage the dependencies in the application. In order to communicate with AWS, the program uses the AWS SDK for Java. 



