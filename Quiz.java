package com.nissan.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Random;
import java.util.Set;
public class Quiz {
	//This map stores all the questions available
	public static HashMap <String,ArrayList<String>> map=realAns();
	//This list is created to for checking the repeatation in questions
	public static ArrayList<Integer> alreadyAsked=new ArrayList<Integer>();
	//For total score
	public static int totalMarks=0;
	//After randomization the questions and ans are stored in this
	public static HashMap<String,List<String>> questionsAsked =new HashMap<String,List<String>>();
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		char choice='n';
		do{
			try{
				System.out.println("Enter your Name: ");
				String name=input.nextLine();
				System.out.println("Lets Start quiz....All the best!!!");
				Object[] arrayQuestions=map.keySet().toArray();
				int k=1;
				while(k<11)
				{
						int index=randInt(0,19);
						if(!alreadyAsked.contains(index))
						{
							System.out.println(arrayQuestions[index]);
							String answer=input.nextLine();
							List<String> answers=map.get(arrayQuestions[index]);
							answers.add(answer);
							if(answers.get(0).equals(answer))
							{
								answers.add("1");
								totalMarks+=1;
							}
							else
							{
								answers.add("0");
							}
							questionsAsked.put((String)arrayQuestions[index], answers);
							k++;
							alreadyAsked.add(index);
							
						}
					}
					
			}
			catch(Exception e)
			{
				System.out.println("Invaild Input...");
			}
			finally
			{
				displayOutput();
				System.out.println("Do you want to give quiz one more time?(y/n)");
				choice=input.nextLine().charAt(0);
			}
		}while(choice=='y'||choice=='Y');

	}
	//displaying output in table format
	public static void displayOutput()
	{
		System.out.println("Your report card");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.format("%5s%30s%20s%20s%10s%n","Question number","Question","Correct Answer","Your Answer","Score");
		System.out.println("----------------------------------------------------------------------------------------------");
		int i=1;
		for(Map.Entry<String,List<String>> pair:questionsAsked.entrySet())
		{
			//System.out.println(pair);
			System.out.format("%5d%40s%20s%20s%10s%n",i,pair.getKey(),pair.getValue().get(0),pair.getValue().get(1),pair.getValue().get(2));
			i++;
		}
		//System.out.println(questionsAsked);
		System.out.println("----------------------------------------------------------------------------------------------");
		if(totalMarks==10)
		{
			System.out.println("---------Outstanding!!! All are correct Keep it up!!!--------------");
		}
		else if(totalMarks<10 && totalMarks>5)
		{
			System.out.println("----------------Good!!!-------------------");
		}
		else if(totalMarks<=5)
		{
			System.out.println("--------------Need Improvement--------------");
		}
		System.out.println("Your Score is "+totalMarks);
	}
	//for original answers
	public static HashMap<String,ArrayList<String>> realAns()
	{
		HashMap <String,ArrayList<String>> hashMap=new HashMap<String,ArrayList<String>>();
		hashMap.put("What is capital of Goa?",getInput("Panaji"));
		hashMap.put("What is capital of Arunachal Pradesh",getInput("Itanagar"));
		hashMap.put("What is capital of Assam?",getInput("Dispur"));
		hashMap.put("What is capital of Bihar?",getInput("Patna"));
		hashMap.put("What is capital of Gujrat?",getInput("Gandhinagar"));
		hashMap.put("What is capital of Haryana?",getInput("Chandigarh"));
		hashMap.put("What is capital of Himachal Pradesh?",getInput("Shimla"));
		hashMap.put("What is capital of Jharkhand?",getInput("Ranchi"));
		hashMap.put("What is capital of Maharashtra?",getInput("Mumbai"));
		hashMap.put("What is capital of Kerala?",getInput("Trivandrum"));
		hashMap.put("What is capital of West Bengal?",getInput("Kolkata"));
		hashMap.put("What is capital of Uttar Pradesh?",getInput("Lucknow"));
		hashMap.put("What is capital of Telangana?",getInput("Hyderabad"));
		hashMap.put("What is capital of Tamil Nadu?",getInput("Chennai"));
		hashMap.put("What is capital of Sikkim?",getInput("Gangtok"));
		hashMap.put("What is capital of Rajasthan?",getInput("Jaipur"));
		hashMap.put("What is capital of Punjab?",getInput("Chandigarh"));
		hashMap.put("What is capital of Odisha?",getInput("Bhubaneswar"));
		hashMap.put("What is capital of Nagaland?",getInput("Kohima"));
		hashMap.put("What is capital of Manipur?",getInput("Imphal"));
		return hashMap;
	}
	//for inserting list as value in hashmap
	public static ArrayList<String> getInput(String correct)
	{
		ArrayList<String> ans=new ArrayList<String>();
		ans.add(correct);
		return ans;
	}
	//generating random value for random question
	public static int randInt(int min, int max) {

		int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		return random_int;
	}
}
