import java.util.Scanner;
class TreeNode {
    String word;
    String definition;
    TreeNode left, right;

    public TreeNode(String word, String definition) {
        this.word = word;
        this.definition = definition;
        this.left = this.right = null;
    }
}

class DictionaryTree {
    private TreeNode root;

    public DictionaryTree() {
        this.root = null;
    }

    public void insert(String word, String definition) {
        root = insertRec(root, word, definition);
    }

    private TreeNode insertRec(TreeNode root, String word, String definition) {
        if (root == null) {
            return new TreeNode(word, definition);
        }
        if (word.compareToIgnoreCase(root.word) < 0) {
            root.left = insertRec(root.left, word, definition);
        } else if (word.compareToIgnoreCase(root.word) > 0) {
            root.right = insertRec(root.right, word, definition);
        }
        return root;
    }

    public String search(String word) {
        return searchRec(root, word);
    }
    private String searchRec(TreeNode root, String word) {
        if (root == null || root.word.equalsIgnoreCase(word)) {
            return (root != null) ? root.definition : null;
        }


        if (word.compareToIgnoreCase(root.word) < 0) {
            return searchRec(root.left, word);
        } else {

            return searchRec(root.right, word);
        }
    }

    public void displayWordsStartingWith(char startingChar) {
        displayWordsStartingWith(root, startingChar);
    }
    private void displayWordsStartingWith(TreeNode root, char startingChar) {
        if (root != null) {

            if (Character.toLowerCase(startingChar) < Character.toLowerCase(root.word.charAt(0))) {
                displayWordsStartingWith(root.left, startingChar);
            }
            // Display words if the startingChar matches
            if (Character.toLowerCase(startingChar) == Character.toLowerCase(root.word.charAt(0))) {
                displayWordsWithSameAlphabet(root, startingChar);
            }

            if (Character.toLowerCase(startingChar) > Character.toLowerCase(root.word.charAt(0))) {
                displayWordsStartingWith(root.right, startingChar);
            }
        }
    }

    // Helper method to display words with the same alphabet
    private void displayWordsWithSameAlphabet(TreeNode root, char startingChar) {
        if (root != null && Character.toLowerCase(startingChar) == Character.toLowerCase(root.word.charAt(0))) {
            displayWordsWithSameAlphabet(root.left, startingChar);
            System.out.println(root.word);
            displayWordsWithSameAlphabet(root.right, startingChar);
        }
    }
}

public class InteractiveDictionary {
    public static void main(String[] args) {
        DictionaryTree dictionary = new DictionaryTree();
        String[] sampleWords = {
                "abacus", "abate", "abide", "abject", "abjure",
                "babble", "backlog", "badger", "baggage", "bailiff",
                "cabal", "cackle", "cadet", "cajole", "calamity",
                "dabble", "dagger", "dainty", "dally", "dampen",
                "eager", "eagle", "earthy", "easel", "eclipse",
                "fabric", "facet", "faint", "falcon", "fallacy",
                "gabble", "gadget", "gaggle", "gaiety", "gallant",
                "habit", "hackney", "haggard", "hailstone", "halcyon",
                "iceberg", "iconic", "idolize", "ignite", "illustrious",
                "jabber", "jackpot", "jaded", "jagged", "jamboree",
                "kangaroo", "karaoke", "keenness", "kennel", "kernel",
                "laborious", "labyrinth", "lacerate", "lackadaisical", "laconic",
                "macabre", "macerate", "madden", "magnify", "malady",
                "nadir", "naive", "narcissism", "nascent", "nautical",
                "oasis", "obdurate", "obfuscate", "oblivion", "obsequious" ,"pacify", "paddle", "palatable", "palindrome", "pallid",
                "quackery", "quadrant", "quaff", "quagmire", "quaint",
                "rabble", "radiant", "raffle", "ragged", "rampant" ,"sabotage", "saccharine", "sacrilege", "saddle", "sagacious" ,"taciturn", "tactile", "talisman", "tantalize", "tarnish",
                "ubiquitous", "ulterior", "ultimate", "umbrage", "unanimous",
                "vacillate", "vagabond", "vain", "valiant", "vanquish",
                "waddle", "waffle", "waggle", "waif", "wallow",
                "xenophobia", "xerography", "xerox", "xylem", "xylophone",
                "yacht", "yammer", "yawn", "yearn", "yield",
                "zealot", "zenith", "zephyr", "zest", "zigzag"
        };

        final String[] sampleDefinitions = {
                //for A
                "a frame with rows of wires or grooves along which beads are slid, used for calculating.",
                "become less intense or widespread.",
                "accept or act in accordance with (a rule, decision, or recommendation).",
                "(of something bad) experienced or present to the maximum degree.",
                "solemnly renounce (a belief, cause, or claim)",
                //for B
                "To talk rapidly and incoherently; to make a continuous murmuring sound.",
                "A accumulation of unfinished work or tasks awaiting completion.",
                "To pester or annoy persistently; to harass.",
                "Personal belongings packed in suitcases for a journey; a person's emotional or psychological burdens.",
                "An officer of the court who is responsible for maintaining order and executing judgments.",
                //for C
                "A secret political clique or faction; a group engaged in intrigue.",
                "To emit a loud, shrill laugh, often with a cackling sound.",
                "A trainee in a military school; a younger sibling.",
                "To persuade someone to do something through flattery or gentle coaxing.",
                "A disastrous event causing harm, distress, or destruction.",
                //for D
                "To work or involve oneself in a superficial or casual manner.",
                "A short, pointed knife; a sharp weapon.",
                "Delicately small and pretty; having refined or exquisite taste.",
                "To waste time; to engage in amorous play.",
                "To make something slightly wet; to suppress or diminish.",
                //for E
                "Showing keen interest or enthusiasm; impatiently longing.",
                "A large bird of prey known for its strong vision and powerful beak and talons.",
                "Relating to the earth or nature; plain and unpretentious.",
                "A stand used to support an artist's canvas or a drawing board.",
                "The partial or complete blocking of one celestial body by another; to overshadow or surpass.",
                //for F
                "Material, typically produced by weaving or knitting textile fibers.",
                "A particular aspect or feature of something.",
                "Lacking in strength or brightness; a brief loss of consciousness",
                "A bird of prey with long wings and a hooked beak, trained for hunting.",
                "A mistaken belief or flawed argument; a deceptive or misleading notion.",
                //for G
                "To talk rapidly and unintelligibly; to chatter incessantly.",
                "A small, useful device or tool.",
                "A group of noisy, chattering geese; a disorderly or noisy group of people.",
                "Cheerfulness, merriment, or joyful exuberance.",
                "Brave, chivalrous, or showing special attention and courtesy to women.",
                //for H
                "A settled or regular tendency, especially one that is hard to give up.",
                "A horse-drawn carriage for hire; overused or clichéd due to being unoriginal.",
                "Looking exhausted and unwell, especially from fatigue, worry, or suffering.",
                "A pellet of hail, typically a rounded or irregular piece of ice.",
                "Denoting a period of calm, peaceful, and prosperous time.",
                //for I
                "A large mass of ice floating in the sea, typically detached from a glacier or ice sheet.",
                "Widely recognized and well-established as a symbol or representation.",
                "To admire or worship someone intensely",
                "To catch fire or cause to catch fire; to start or trigger a reaction.",
                "Well-known, respected, and admired for achievements or contributions.",
                //for J
                "To talk rapidly and unintelligibly; to chatter.",
                "The large prize in a game of chance or lottery; a significant success or achievement.",
                "Lacking enthusiasm or feeling tired, typically from overwork or an excess of something.",
                "Having rough, sharp points or edges; uneven or irregular.",
                "A large, festive gathering or celebration.",
                //for K
                "A large marsupial with powerful hind legs, native to Australia.",
                "A form of entertainment where people sing along to recorded music.",
                "Eagerness, enthusiasm, or a sharp edge or point.",
                "A shelter or boarding house for dogs.",
                "The softer, usually edible part of a seed, nut, or fruit stone.",
                //for L
                "Requiring a lot of effort and hard work; tedious.",
                "A complex and confusing network of passages; a maze.",
                "To tear or cut deeply, causing injury.",
                "Lacking enthusiasm, energy, or effort; casual or indifferent.",
                "Using very few words; concise to the point of being terse.",
                //for M
                "Disturbing and horrifying, often dealing with death or the gruesome.",
                "To soften or break down by soaking; to make soft or dissolve.",
                "To drive someone mad or make them extremely angry.",
                "To make something appear larger; to exaggerate or intensify.",
                "A disease or ailment; an undesirable condition.",
                //for N
                "The lowest point; the point on the celestial sphere directly below an observer.",
                "Lacking experience or sophistication; innocent or simple.",
                "Excessive self-love or admiration; a personality trait characterized by self-centeredness.",
                "Coming into existence; beginning to develop or form.",
                "Related to ships, sailors, or navigation on water.",
                //for 0
                "A fertile area in a desert with water, where vegetation and wildlife thrive.",
                "Stubbornly refusing to change one's opinion or course of action; resistant to persuasion.",
                "To deliberately make something unclear or difficult to understand.",
                "The state of being forgotten or unknown; the state of being completely forgotten or overlooked.",
                "Excessively obedient or attentive; overly submissive.",
                //for P
                "To bring peace or calm to a situation; to appease or soothe.",
                "A short oar with a flat blade, used for propelling a canoe or small boat.",
                "Pleasant to taste; acceptable or agreeable.",
                "A word, phrase, or sequence that reads the same backward as forward (e.g., (level) or (madam)).",
                "Pale in color; lacking color or vitality.",
                //for Q
                "The promotion of fraudulent or unproven medical practices.",
                "A quarter of a circle; an instrument for measuring angles.",
                "To drink heartily or in large quantities.",
                "A soft, muddy area that is difficult to navigate; a complex or difficult situation.",
                "Attractively unusual or old-fashioned.",
                //for R
                "A disorderly crowd; a mob.",
                "Emitting light or shining brightly; expressing great joy or happiness.",
                "A lottery in which participants buy tickets for a chance to win a prize.",
                "Torn or frayed; wearing tattered clothing.",
                "Uncontrolled or unrestrained; widespread.",
                //for S
                "Deliberate destruction or disruption, often for political or military purposes.",
                "Excessively sweet or sentimental.",
                "The violation or misuse of something considered sacred.",
                "A seat for a rider on the back of a horse or bicycle; to burden or encumber.",
                "Wise, discerning, and judicious.",
                //for T
                "Reserved or uncommunicative in speech; silent.",
                "Relating to the sense of touch.",
                "An object believed to bring good luck or have magical properties.",
                "To torment or tease with the promise of something unattainable.",
                "To dull or discolor the surface of metal; to damage or destroy the luster of something.",
                //for U
                "Present, appearing, or found everywhere.",
                "Existing beyond what is obvious or admitted; intentionally hidden.",
                "The final or greatest point; the best achievable or imaginable.",
                "Offense or annoyance; a feeling of resentment.",
                "Fully in agreement; having the agreement of all.",
                //for V
                "To waver in one's mind or opinions; to be indecisive.",
                "A person who wanders from place to place without a home; a nomad.",
                "Excessively proud or concerned about one's own appearance or achievements.",
                "Possessing or showing courage and determination.",
                "To defeat thoroughly; to conquer or overcome.",
                //fro W
                "To walk with short steps, swaying from side to side.",
                "To speak or write evasively; to vacillate in decision-making.",
                "To move with short, quick movements from side to side.",
                "A homeless and helpless person, especially a child.",
                "To roll about or lie in water, snow, mud, etc.; to indulge in an unrestrained way.",
                //fro X
                "Dislike of or prejudice against people from other countries.",
                "A photocopying process using electrically charged plates.",
                "A brand name for a photocopying machine; to make a photocopy.",
                "The vascular tissue in plants that conducts water and nutrients.",
                "A musical instrument consisting of a set of wooden bars struck to produce musical tones.",
                //for Y
                "A medium to large boat for pleasure, typically equipped for racing.",
                "To complain or whine persistently.",
                "To involuntarily open the mouth wide and take a long breath, often as a sign of tiredness.",
                "To have an intense longing or desire.",
                "To produce or provide; to give way under pressure.",
                //for Z
                "A person who is fanatical and uncompromising in pursuit of their religious, political, or other ideals.",
                "The highest point reached by a celestial or other object; the point in the sky directly above an observer.",
                "A gentle, mild breeze.",
                "Enthusiastic and vigorous enjoyment; the outer peel of citrus fruit used for flavor.",
                "A pattern or path characterized by sharp turns in alternating directions.",
        };

        for (int i = 0; i < sampleWords.length; i++) {
            dictionary.insert(sampleWords[i], sampleDefinitions[i]);
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the alphabet to search words (type 'exit' to quit): ");
            String alphabetInput = scanner.nextLine().toLowerCase();
            if (alphabetInput.equals("exit")) {
                break;
            }
            if (alphabetInput.length() != 1 || !Character.isLetter(alphabetInput.charAt(0))) {
                System.out.println("Please enter a valid alphabet.");
                continue;
            }
            char startingChar = alphabetInput.charAt(0);
            System.out.println("Words starting with '" + startingChar + "':");
            dictionary.displayWordsStartingWith(startingChar);
            System.out.print("Enter a word from the list to get its definition: ");
            String wordInput = scanner.nextLine().toLowerCase();
            String definition = dictionary.search(wordInput);
            if (definition != null) {
                System.out.println("Definition found for '" + wordInput + "': " + definition);
            } else {
                System.out.println("Definition not found for '" + wordInput + "'. Suggestions:");
                dictionary.displayWordsStartingWith(startingChar);
            }
        }
        System.out.println("Exiting dictionary application. Goodbye!");
    }
}
