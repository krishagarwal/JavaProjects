import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;


public class Main
{
	public static void main(String[] args)
	{
		ExerciseData data = loadData();

		//LocalDate today = LocalDate.now();

		Scanner myScan = new Scanner(System.in);

		//Period timeSinceLastSave = (data.date).until(LocalDate.now());

		Period timeSinceLastSave = Period.between(data.date, LocalDate.now());
		int days = timeSinceLastSave.getDays();
		data.exerciseMinutes = (days * 30) + data.exerciseMinutes;
		saveData(data);

		System.out.println("Today you need to exercise for " + data.exerciseMinutes + " minutes.");

		boolean doNotExit = true;

		while (doNotExit)
		{
			System.out.println("Type 'm' to record minutes you have exercised. Type 'c' to record the calories you have consumed. Type 'e' to exit.");
			String input = myScan.next();

			if (input.equalsIgnoreCase("m"))
			{
				System.out.println("How many minutes have you exercised?");
				int minutesExercised = myScan.nextInt();
				data.exerciseMinutes = data.exerciseMinutes - minutesExercised;
				saveData(data);

				if (data.exerciseMinutes < 0)
				{
					System.out.println("You have exercised for " + Math.abs(data.exerciseMinutes) + " minutes extra.");
					System.out.println("You can consume " + (data.exerciseMinutes * -10) + " calories today without having to exercise more.");
				}
				else if (data.exerciseMinutes == 0)
				{
					System.out.println("You are finished with your exercise today as long as you don't consume more calories.");
				}
				else
				{
					System.out.println("You need to exercise for " + data.exerciseMinutes + " minutes.");
				}
			}
			else if (input.equalsIgnoreCase("c"))
			{
				System.out.println("How many calories have you consumed?");
				int caloriesConsumed = myScan.nextInt();

				data.exerciseMinutes = (caloriesConsumed/10) + data.exerciseMinutes;
				saveData(data);

				if (data.exerciseMinutes < 0)
				{
					System.out.println("You still have exercised for " + Math.abs(data.exerciseMinutes) + " minutes extra.");
					System.out.println("You can still consume " + (data.exerciseMinutes * -10) + " more calories today without having to exercise more.");
				}
				else if (data.exerciseMinutes == 0)
				{
					System.out.println("You are finished with your exercise today as long as you don't consume more calories.");
				}
				else
				{
					System.out.println((caloriesConsumed/10) + " minutes have been added. You now have " + data.exerciseMinutes + " minutes in total.");
				}
			}
			else if (input.equalsIgnoreCase("e"))
			{
				doNotExit = false;
				saveData(data);
			}
			else
			{
				System.out.println("That is not an action you can take.");
			}
		}
	}

	public static ExerciseData loadData()
	{
		ExerciseData exerciseData = new ExerciseData();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("exercise.txt"));
			String sCurrentLine = br.readLine();
			String[] data = sCurrentLine.split(",", 2);
			exerciseData.date = LocalDate.parse(data[0]);
			exerciseData.exerciseMinutes = Integer.parseInt(data[1]);
		}
		catch (java.io.IOException e)
		{
			exerciseData.date = LocalDate.now();
			exerciseData.exerciseMinutes = 30;
		}
		return exerciseData;
	}

	public static void saveData(ExerciseData data)
	{
		try
		{
			PrintWriter writer = new PrintWriter("exercise.txt", "UTF-8");
			writer.println(data.date + "," + data.exerciseMinutes);
			writer.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
}