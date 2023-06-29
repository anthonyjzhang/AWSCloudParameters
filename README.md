<h1>☁️ AWS Cloud Parameters v1 </h1> 

A web application that retrieves and filters parameters in Cell Signaling Technology's AWS account. 

<h2> 📄 Summary </h2> 

This project was part of my internship for Cell Signaling Technologies (CST). At CST, I worked under the Director of Software Engineering, where I learned how CST leverages Amazon Web Services (AWS) to manage and build their digital infrastructure and gained hands-on experience with foundational AWS services such as EC2, S3, VPCs, IAM, Lambda, and more. The purpose of this project is to retrieve and filter parameters stored in Parameter Store in AWS Systems Managager. My code first securely authenticates an AWS account using an AWS access key and secret key. Note that these credentials are not hard coded into the program, as this would impact security. Then, the program sets the AWS Region and makes a request to AWS Systems Manager Parameter Store. The program implements three API functions. The first function, listParameters, lists all parameters in the associated AWS account's Parameter Store. The second function, listKeys, lists all of the parameters in the associated AWS account's Parameter Store that contain an input prefix, allowing you to filter parameters by environment, owner, and other identifiers. The third function, getParameter, allows you to retrieve the value of the parameter associated with an input key in the associated AWS account's Parameter Store. Each function returns HTTP status responses. Status code 100 for a valid request, status code 400 for a bad request due to an invalid input, and status code 500 for an internal server error. 

<h2> 💻 Softwares and Technologies </h2> 

- Amazon Web Services (AWS)
- AWS SDK for Java
- Maven
- Spring Boot


