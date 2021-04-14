# quotes

## description 
- app take an json file as input and convert it to Object class to take some data from it then convert it back to json and print it randomly 

## instructions 
- first add library to your dependencies to can you use the Gson library
- go to intillj app 
- go to build gradle and add the implementation 'com.google.code.gson:gson:2.8.6'
- re bulid project to install library
- go to main class and call the Gson object then you can use it 
- # Try this example

` Gson gson = new Gson();`
`gson.toJson(1);            // ==> 1`
`gson.toJson("abcd");       // ==> "abcd"`
`gson.toJson(new Long(10)); // ==> 10`
`int[] values = { 1 };`
`gson.toJson(values);       // ==> [1]`

`// Deserialization`
`int one = gson.fromJson("1", int.class);`
`Integer one = gson.fromJson("1", Integer.class);`
`Long one = gson.fromJson("1", Long.class);`
`Boolean false = gson.fromJson("false", Boolean.class);`
`String str = gson.fromJson("\"abc\"", String.class);`
`String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);`

# lab 9
## description 
- app that connect with internet and send get request to the aoi then return data from the api and display it 

## instructions 
- create URL object and put the api address
- create function to connect to api that use HTTPUrlConnection object
- create a BufferedReader object to reade the data from api
- create function getContact that reade the data from BufferedReader and store it in StringBuilder and return it 
- finally we need to crate function that call the class that we need to pass the data to it 