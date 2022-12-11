import java.io.*;
class Dictionary
{

 public WordTree WordList[] = new WordTree[26];
 public int ListSize[];

 public Dictionary()
 {
  ListSize=new int[26];
  for (char namecount=97;namecount<=122;namecount++)  
  {
   String name=namecount+"";
   WordList[namecount-97]=new WordTree(name);
   ListSize[namecount-97]=0;
  }
 }

 public void getWordMeaning() throws java.io.IOException
 {
  String word,meaning;
  System.out.print("Enter Word: ");
  word = read.GetString();
  System.out.print("Enter Meaning: ");
  meaning = read.GetString();
  WordList[getIndex(word)].addEntry(word,meaning);
  ListSize[getIndex(word)]++;
  System.out.print("Word entered at location "+getIndex(word)+"\n");
 }

 public void deleteWordMeaning() throws NullPointerException, java.io.IOException
 {
  String word;
  System.out.print("Enter word: ");
  word=read.GetString();
  WordList[getIndex(word)].deleteEntry(word);
  ListSize[getIndex(word)]--;
  System.out.println(word + " deleted");
 }

 public void findMeaning() throws NullPointerException, java.io.IOException
 {
  String word;
  System.out.print("Enter word: ");
  word=read.GetString();
  System.out.println("\n"+word+": "+WordList[getIndex(word)].findEntry(word));
 }

 public void displayWordTree() throws java.io.IOException
 {
  char letter;
  System.out.print("Enter Letter : ");
  letter=read.GetChar();
  if (letter>=65&&letter<=90)
  {
   System.out.println("The words starting with "+letter+" are as follows:");
   WordList[letter-65].displayTree();
  }
  else if (letter>=97&&letter<=122)
  {
   System.out.println("The words starting with "+letter+" are as follows:");
   WordList[letter-97].displayTree();
  }
  else
   System.out.println("Not a valid input");
 }

 public void displayWordList()
 {
  System.out.println("The contents of the Dictionary are: ");
  for (int index=0;index<=25;index++)
   if (ListSize[index]>0)
    WordList[index].displayTree();     
 }

 public void saveWordMeaning() throws java.io.IOException
 {

  for (int index=0;index<=25;index++){
   if (ListSize[index]>0){
    System.out.println(ListSize[index]+": "+index);
    WordList[index].saveTree(ListSize[index]);}}
  System.out.println("Dictionary has been written to files.");
 }

 public void loadWordMeaning() throws java.io.IOException
 {
  for (int index=0;index<=25;index++)
  {
   String filename=WordList[index].Name;
   filename=filename.concat(".txt");
   File checkfile=new File(filename);
   if (checkfile.exists())
    WordList[index].loadTree();
  }
   System.out.println("Dictionary has been loaded");
 }

 public void getNodeCount() throws java.io.IOException
 {
  System.out.println();
  System.out.print("Enter a letter: ");
  char letter=read.GetChar();
  if (letter>=65&&letter<=90)
   System.out.println("Entries for "+letter+": "+ListSize[letter-65]);
  else if (letter>=97&&letter<=122)
   System.out.println("Entries for "+letter+": "+ListSize[letter-97]);
  else
   System.out.println("Invalid input, try again");   
 }


 public int getIndex(String word)
 {
  int firstchar=word.charAt(0);
  if (firstchar>=65&&firstchar<=90)
   return (firstchar-65);
  else if (firstchar>=97&&firstchar<=122)
   return (firstchar-97);
  else
  {
   System.out.println("Not a valid input");
   return -1;
  }
 }
}

public class main
{
 public static void main(String args[]) throws Exception
 {
  Dictionary dict=new Dictionary();
  char option;

  System.out.print("             DICTIONARY       ");

  System.out.print("\nChoose an Option");
  System.out.print("\n");
  do
  {
   System.out.println();
   System.out.println("Press 'I', for inserting new word-meaning");
   System.out.println("Press 'D', for deleting a word-meaning");
   System.out.println("Press 'F', for finding a meaning");
   System.out.println("Press 'T', to view a word tree");
   System.out.println("Press 'E', to view the entire dictionary");
   System.out.println("Press 'S', to save the dictionary");
   System.out.println("Press 'L', to load a dictionary");
   System.out.println("Press 'N', to view the enties in word tree");
   System.out.println("Press 'X', to exit");
   System.out.print("Press Enter to start");
   read.FlushInput();
   System.out.println();
   System.out.print("Enter an option: ");
   option=read.GetChar();
   read.FlushInput();

   switch(option)
   {
    case 'I': case 'i': dict.getWordMeaning(); break;
    case 'D': case 'd': dict.deleteWordMeaning(); break;
    case 'F': case 'f': dict.findMeaning(); break;
    case 'T': case 't': dict.displayWordTree(); break;
    case 'E': case 'e': dict.displayWordList(); break;
    case 'S': case 's': dict.saveWordMeaning(); break;
    case 'L': case 'l': dict.loadWordMeaning(); break;
    case 'N': case 'n': dict.getNodeCount(); break;
    case 'X': case 'x': System.out.println("Thank you for using The Dictionary, good-bye for now."); System.exit(0);
    default: System.out.println("Incorrect input, try again.");
   }
  }
  while (true);
 } 
}

