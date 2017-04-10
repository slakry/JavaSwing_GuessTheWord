import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class MainGame extends JFrame {
	private GameRules gameRules;
	private JPanel controlPanel;
	private JFrame mainFrame;
	private JMenuBar menuBar;
	private JMenu menuCategory, menuRules, menuLevel, menuAuthor;
	private JRadioButtonMenuItem miCountries, miCapitals, miFemaleNames, miMaleNames, miAnimals, miProgramming, miArtists,
									miIT, miEmpty;
	private ButtonGroup groupRadioButtonMenuItem, groupLevels;
	private JMenuItem miGameRules, miAboutAuthor;
	private JRadioButtonMenuItem miEasyLevel, miMediumLevel, miHardLevel;
	private JTextField tfMixedWord, tfUsersWord, tfRightWord, tfTrials, tfPoints;
	private JLabel labelCategory;
	private JButton buttonCheck, buttonStart, buttonNext, buttonClose;
	private Category category = Category.EMPTY;
	private CategoryPathEasy categoryPathEasy;
	private CategoryPathMedium categoryPathMedium;
	private CategoryPathHard categoryPathHard;
	private WordMixer mixedWord;
	private ReaderFile readerFile;
	private String rightFileWord, mixedFileWord;
	
	private int usersPoints = 0;
	private int usersTrials = 3;
	private int allPoints = 0;
	
	public static void main(String[] args) {
			
			new MainGame().createGUI();
		
		}

	private void createGUI() {
		mainFrame = new JFrame("Guess the word ver. 1.0");
        
		//ODCZYT OBRAZKA JAKO T£O DO GRY - TAK ABY BY£ W PLIKU JAR
        try {
            BufferedImage bufferedImage = ImageIO.read(getClass().getResource("/img/mainFrame_background.png"));
            JLabel labelImage = new JLabel(new ImageIcon(bufferedImage));
            mainFrame.setContentPane(labelImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		mainFrame.pack();	//dopasowanie rozmiaru do wielkosci obrazka
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(null);
		
		//MENU
		menuBar = new JMenuBar();
		 menuCategory = new JMenu("Wybierz Kategoriê");
		 menuRules = new JMenu("Zasady gry");
		 menuLevel = new JMenu("Poziom trudnoœci");
		 menuAuthor = new JMenu("Autor");
			menuBar.add(menuCategory);
			menuBar.add(menuLevel);
			menuBar.add(menuRules);
			menuBar.add(menuAuthor);
		
		//RADIO CHECK BOX MENU ITEM
		 miCountries = new JRadioButtonMenuItem("Pañstwa");
		 miCapitals = new JRadioButtonMenuItem("Stolice");
		 miFemaleNames = new JRadioButtonMenuItem("¯eñskie imiona");
		 miMaleNames = new JRadioButtonMenuItem("Mêskie imiona");
		 miAnimals = new JRadioButtonMenuItem("Zwierzêta");
		 miProgramming = new JRadioButtonMenuItem("Programowanie");
		 miArtists = new JRadioButtonMenuItem("Artyœci");
		 miIT = new JRadioButtonMenuItem("IT");

		 miEmpty = new JRadioButtonMenuItem("");
		 
		 menuCategory.add(miCountries);
		 menuCategory.add(miCapitals);
		 menuCategory.add(miFemaleNames);
		 menuCategory.add(miMaleNames);
		 menuCategory.add(miAnimals);
		 menuCategory.add(miProgramming);
		 menuCategory.add(miArtists);
		 menuCategory.add(miIT);
		 
		 //TWORZYMY GRUPÊ (dziêki temu bêdzie mo¿na wybraæ tylko jedn¹ kategoriê)
		 ButtonGroup groupRadioButtonMenuItem = new ButtonGroup();
		 groupRadioButtonMenuItem.add(miCountries);
		 groupRadioButtonMenuItem.add(miCapitals);
		 groupRadioButtonMenuItem.add(miFemaleNames);
		 groupRadioButtonMenuItem.add(miMaleNames);
		 groupRadioButtonMenuItem.add(miAnimals);
		 groupRadioButtonMenuItem.add(miProgramming);
		 groupRadioButtonMenuItem.add(miArtists);
		 groupRadioButtonMenuItem.add(miIT);
		 groupRadioButtonMenuItem.add(miEmpty);
		 miEmpty.setSelected(true);

		 //POZIOMY TRUDNOŒCI
		 miEasyLevel = new JRadioButtonMenuItem("³atwy");
		 miMediumLevel = new JRadioButtonMenuItem("œredni");
		 miHardLevel = new JRadioButtonMenuItem("trudny");
		 
		 menuLevel.add(miEasyLevel);
		 menuLevel.add(miMediumLevel);
		 menuLevel.add(miHardLevel);
		 
		 ButtonGroup groupLevels = new ButtonGroup();
		 groupLevels.add(miEasyLevel);
		 groupLevels.add(miMediumLevel);
		 groupLevels.add(miHardLevel);
		 miEasyLevel.setSelected(true);
		 
		 //ACTIONLISTENER
		 miCountries.addActionListener(new CountriesListener());
		 miCapitals.addActionListener(new CapitalsListener());
		 miFemaleNames.addActionListener(new FemaleNamesListener());
		 miMaleNames.addActionListener(new MaleNamesListener());
		 miAnimals.addActionListener(new AnimalsListener());
		 miProgramming.addActionListener(new ProgrammingListener());
		 miArtists.addActionListener(new ArtistsListener());
		 miIT.addActionListener(new ITListener());
		  
		//MENU ITEM
		miGameRules = new JMenuItem("Zasady gry");
		miGameRules.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameRules = new GameRules();
				try {
					gameRules.main(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		menuRules.add(miGameRules);

		miAboutAuthor = new JMenuItem("O Autorze");
		miAboutAuthor.addActionListener(new AuthorListener());
			menuAuthor.add(miAboutAuthor);
		
		mainFrame.setJMenuBar(menuBar);
		
		//TEXT FIELD
		tfMixedWord = new JTextField();
		tfMixedWord.setEditable(false);
		tfMixedWord.setFont(new Font("arial", Font.BOLD, 16));
		tfMixedWord.setBounds(270, 150, 340, 40);
		mainFrame.add(tfMixedWord);
		
		tfUsersWord = new JTextField(); 
		tfUsersWord.addKeyListener(new UsersWordListener());
		tfUsersWord.setEditable(false);
		tfUsersWord.setFont(new Font("arial", Font.BOLD, 16));
		tfUsersWord.setBounds(270, 210, 340, 40);
		mainFrame.add(tfUsersWord);
		
		tfRightWord = new JTextField(); 
		tfRightWord.setEditable(false);
		tfRightWord.setFont(new Font("arial", Font.BOLD, 16));
		tfRightWord.setBounds(270, 310, 340, 40);
		mainFrame.add(tfRightWord);;
		
		tfTrials = new JTextField(); 
		tfTrials.setEditable(false);
		tfTrials.setFont(new Font("arial", Font.BOLD, 16));
		tfTrials.setBounds(270, 360, 40, 40);
		mainFrame.add(tfTrials);
		
		tfPoints = new JTextField();
		tfPoints.setHorizontalAlignment(SwingConstants.CENTER);		//wyswietlenie tekstu w srodku
		tfPoints.setEditable(false);
		tfPoints.setFont(new Font("arial", Font.BOLD, 16));
		tfPoints.setBounds(530, 360, 80, 40);
		mainFrame.add(tfPoints);
		
		//LABEL
		labelCategory = new JLabel(category.toString());
		labelCategory.setFont(new Font("arial", Font.BOLD, 16));
		labelCategory.setBounds(270, 91, 300, 40);
		mainFrame.add(labelCategory);
		
		
		//BUTTONS
		buttonCheck = new JButton("> Sprawdz <");
		buttonCheck.addActionListener(new CheckListener());
		buttonCheck.setBounds(270, 260, 150, 40);
		buttonCheck.setEnabled(false);
		mainFrame.add(buttonCheck);
		
		buttonStart = new JButton("Rozpocznij");
		buttonStart.addActionListener(new StartListener());
		buttonStart.setBounds(80, 415, 150, 40);
		buttonStart.setEnabled(false);
		mainFrame.add(buttonStart);
		
		buttonNext = new JButton("Losuj");
		buttonNext.addActionListener(new NextListener());
		buttonNext.setBounds(270, 415, 150, 40);
		buttonNext.setEnabled(false);
		mainFrame.add(buttonNext);
		
		buttonClose = new JButton("Zakoñcz");
		buttonClose.addActionListener(new StopListener());
		buttonClose.setBounds(460, 415, 150, 40);
		buttonClose.setEnabled(false);
		mainFrame.add(buttonClose);
		
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
	}
	
	//KLASY WEWNÊTRZNE
	private class AuthorListener extends JOptionPane implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(this, ">>> S³awomir Kryniewski <<<", "About Author", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
		//BOX MENU ITEM
	private class CountriesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			category = Category.COUNTRIES;
			labelCategory.setText(category.toString());
			buttonStart.setEnabled(true);
		}
	}
	
	private class CapitalsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			category = Category.CAPITALS;
			labelCategory.setText(category.toString());
			buttonStart.setEnabled(true);
		}
	}
		
	private class FemaleNamesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			category = Category.FEMALE_NAMES;
			labelCategory.setText(category.toString());
			buttonStart.setEnabled(true);
		}
	}
	
	private class MaleNamesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			category = Category.MALE_NAMES;
			labelCategory.setText(category.toString());
			buttonStart.setEnabled(true);
		}
	}
	
	private class AnimalsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			category = Category.ANIMALS;
			labelCategory.setText(category.toString());
			buttonStart.setEnabled(true);
		}	
	}
	
	private class ProgrammingListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			category = Category.PROGRAMMING;
			labelCategory.setText(category.toString());
			buttonStart.setEnabled(true);
		}	
	}
	
	private class ArtistsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			category = Category.ARTISTS;
			labelCategory.setText(category.toString());
			buttonStart.setEnabled(true);
		}	
	}
	
	private class ITListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			category = Category.IT;
			labelCategory.setText(category.toString());
			buttonStart.setEnabled(true);
		}	
	}
		
	//TEXTFIELD
	private class UsersWordListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				checkWord();
				if (usersTrials==0) {
					tfUsersWord.setFocusable(false);
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}
	}
	
	//BUTTONS
	private class StartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			menuCategory.setEnabled(false);
			
			tfUsersWord.setEditable(false);
			buttonNext.setEnabled(true);
			buttonCheck.setEnabled(false);
			buttonClose.setEnabled(true);
			buttonStart.setEnabled(false);
		}
	}
	
	private class CheckListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			checkWord();
		}
	}
	
	private class NextListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		//PAÑSTWA
			if (category.equals(category.COUNTRIES)) {
				if (miEasyLevel.isSelected()==true) {
					categoryPathEasy = CategoryPathEasy.COUNTRIES_PATH_EASY;
					run(categoryPathEasy.toString());
				} else if (miMediumLevel.isSelected()==true) {
					categoryPathMedium = CategoryPathMedium.COUNTRIES_PATH_MEDIUM;
					run(categoryPathMedium.toString());
				} else if (miHardLevel.isSelected()==true) {
					categoryPathHard = CategoryPathHard.COUNTRIES_PATH_HARD;
					run(categoryPathHard.toString());
				}
			}
		//MIASTA
			if (category.equals(category.CAPITALS)) {
				if (miEasyLevel.isSelected()==true) {
					categoryPathEasy = CategoryPathEasy.CAPITALS_PATH_EASY;
					run(categoryPathEasy.toString());
				} else if (miMediumLevel.isSelected()==true) {
					categoryPathMedium = CategoryPathMedium.CAPITALS_PATH_MEDIUM;
					run(categoryPathMedium.toString());
				} else if (miHardLevel.isSelected()==true) {
					categoryPathHard = CategoryPathHard.CAPITALS_PATH_HARD;
					run(categoryPathHard.toString());
				}
			}	
		//¯EÑSKIE IMIONA
			if (category.equals(category.FEMALE_NAMES)) {
				if (miEasyLevel.isSelected()==true) {
					categoryPathEasy = CategoryPathEasy.FEMALE_NAMES_PATH_EASY;
					run(categoryPathEasy.toString());
				} else if (miMediumLevel.isSelected()==true) {
					categoryPathMedium = CategoryPathMedium.FEMALE_NAMES_PATH_MEDIUM;
					run(categoryPathMedium.toString());
				} else if (miHardLevel.isSelected()==true) {
					categoryPathHard = CategoryPathHard.FEMALE_NAMES_PATH_HARD;
					run(categoryPathHard.toString());
				}
			}
		//MÊSKIE IMIONA
			if (category.equals(category.MALE_NAMES)) {
				if (miEasyLevel.isSelected()==true) {
					categoryPathEasy = CategoryPathEasy.MALE_NAMES_PATH_EASY;
					run(categoryPathEasy.toString());
				} else if (miMediumLevel.isSelected()==true) {
					categoryPathMedium = CategoryPathMedium.MALE_NAMES_PATH_MEDIUM;
					run(categoryPathMedium.toString());
				} else if (miHardLevel.isSelected()==true) {
					categoryPathHard = CategoryPathHard.MALE_NAMES_PATH_HARD;
					run(categoryPathHard.toString());
				}
			}
		//ZWIERZÊTA
			if (category.equals(category.ANIMALS)) {
				if (miEasyLevel.isSelected()==true) {
					categoryPathEasy = CategoryPathEasy.ANIMALS_PATH_EASY;
					run(categoryPathEasy.toString());
				} else if (miMediumLevel.isSelected()==true) {
					categoryPathMedium = CategoryPathMedium.ANIMALS_PATH_MEDIUM;
					run(categoryPathMedium.toString());
				} else if (miHardLevel.isSelected()==true) {
					categoryPathHard = CategoryPathHard.ANIMALS_PATH_HARD;
					run(categoryPathHard.toString());
				}
			}
		//PROGRAMOWANIE
			if (category.equals(category.PROGRAMMING)) {
				if (miEasyLevel.isSelected()==true) {
					categoryPathEasy = CategoryPathEasy.PROGRAMMING_PATH_EASY;
					run(categoryPathEasy.toString());
				} else if (miMediumLevel.isSelected()==true) {
					categoryPathMedium = CategoryPathMedium.PROGRAMMING_PATH_MEDIUM;
					run(categoryPathMedium.toString());
				} else if (miHardLevel.isSelected()==true) {
					categoryPathHard = CategoryPathHard.PROGRAMMING_PATH_HARD;
					run(categoryPathHard.toString());
				}
			}
		//ARTYŒCI
			if (category.equals(category.ARTISTS)) {
				if (miEasyLevel.isSelected()==true) {
					categoryPathEasy = CategoryPathEasy.ARTISTS_PATH_EASY;
					run(categoryPathEasy.toString());
				} else if (miMediumLevel.isSelected()==true) {
					categoryPathMedium = CategoryPathMedium.ARTISTS_PATH_MEDIUM;
					run(categoryPathMedium.toString());
				} else if (miHardLevel.isSelected()==true) {
					categoryPathHard = CategoryPathHard.ARTISTS_PATH_HARD;
					run(categoryPathHard.toString());
				}
			}
		//IT
			if (category.equals(category.IT)) {
				if (miEasyLevel.isSelected()==true) {
					categoryPathEasy = CategoryPathEasy.IT_PATH_EASY;
					run(categoryPathEasy.toString());
				} else if (miMediumLevel.isSelected()==true) {
					categoryPathMedium = CategoryPathMedium.IT_PATH_MEDIUM;
					run(categoryPathMedium.toString());
				} else if (miHardLevel.isSelected()==true) {
					categoryPathHard = CategoryPathHard.IT_PATH_HARD;
					run(categoryPathHard.toString());
				}
			}
			
			tfUsersWord.setText("");
			buttonCheck.setEnabled(true);
		}
	} //koniec 
	
	private class StopListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			category = Category.EMPTY;
			labelCategory.setText(category.toString());
			tfPoints.setText("");
			tfTrials.setText("");
			
			rightFileWord = mixedFileWord = null;
			usersPoints = 0;
			usersTrials = 3;
			allPoints = 0;
			menuCategory.setEnabled(true);
			tfUsersWord.setEditable(false);
			buttonCheck.setEnabled(false);
			buttonStart.setEnabled(false);
			buttonNext.setEnabled(false);
			tfMixedWord.setText("");
			tfUsersWord.setText("");
			tfRightWord.setText("");
			miEmpty.setSelected(true);			//wybranie Empty który jest w box a nie ma go w menuitem
			buttonClose.setEnabled(false);
		}
	}
	
	private void setPoints() {
		String uPoints = String.valueOf(usersPoints);
		String aPoints = String .valueOf(allPoints);
		
		if (uPoints.length() == 1) {
			uPoints = "0" + usersPoints;
		}
		if (aPoints.length() == 1) {
			aPoints = "0" + allPoints;
		}
		tfPoints.setText(uPoints + " / " + aPoints);
	} //koniec metody setPoints
	
	
	private void run(String pathFromToString) {
		readerFile = new ReaderFile();
		mixedWord = new WordMixer();
		
		rightFileWord = readerFile.readFile(pathFromToString);
		mixedFileWord = rightFileWord;
		tfUsersWord.setEditable(true);
		tfUsersWord.setFocusable(true);
		tfUsersWord.requestFocusInWindow();
		tfRightWord.setText("");
		
		tfMixedWord.setText(mixedWord.checkAndMixWord(mixedFileWord));
		
		usersTrials = 3;
		setPoints();
		tfTrials.setText("   "+usersTrials);
		buttonNext.setEnabled(false);
	} //koniec metody run
	
	private void checkWord() {
		String usersAnswer = tfUsersWord.getText().toUpperCase();
		if (usersAnswer.equals(rightFileWord)){
			usersPoints++;
			allPoints++;
			setPoints();
			tfUsersWord.setText("");
			tfUsersWord.setEditable(false);
			tfRightWord.setText(rightFileWord);
			tfUsersWord.setFocusable(false);
			buttonCheck.setEnabled(false);
			buttonNext.setEnabled(true);
			
		}
		else if (!(usersAnswer.equals(rightFileWord))) {		//(usersAnswer != tfUsersWord.getText().toUpperCase())
			usersTrials--;
			tfTrials.setText("   "+usersTrials);
			tfUsersWord.setText("");
			tfUsersWord.requestFocusInWindow();
			
			if (usersTrials == 0) {
				allPoints++;
				setPoints();
				tfRightWord.setText(rightFileWord);
				tfUsersWord.setEditable(false);
				tfUsersWord.setFocusable(false);
				buttonCheck.setEnabled(false);
				buttonNext.setEnabled(true);
			}
		}
	} //koniec metody checkWord	
}
	
	
	
