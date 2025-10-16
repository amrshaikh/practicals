document.addEventListener('DOMContentLoaded', function() {
    // Mobile Menu Toggle
    const mobileMenuButton = document.getElementById('mobile-menu-button');
    const mobileMenu = document.getElementById('mobile-menu');
    mobileMenuButton.addEventListener('click', () => {
        mobileMenu.classList.toggle('hidden');
    });

    // Tab functionality
    const tabLinks = document.querySelectorAll('.tab-link');
    const tabPanes = document.querySelectorAll('.tab-pane');

    tabLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            
            // Deactivate all links and panes
            tabLinks.forEach(l => l.classList.remove('active-tab'));
            tabPanes.forEach(p => p.classList.add('hidden'));

            // Activate clicked link and corresponding pane
            this.classList.add('active-tab');
            const tabId = this.getAttribute('data-tab');
            document.getElementById(tabId).classList.remove('hidden');
        });
    });

    // Quiz functionality
    const quizData = [
        {
            question: "What percentage of the world's water is fresh water?",
            answers: ["~3%", "~10%", "~25%", "~50%"],
            correct: 0
        },
        {
            question: "Which of the following is NOT a major greenhouse gas?",
            answers: ["Carbon Dioxide", "Methane", "Nitrous Oxide", "Oxygen"],
            correct: 3
        },
        {
            question: "How long does it take for a plastic bottle to decompose?",
            answers: ["~50 years", "~100 years", "~200 years", "~450 years"],
            correct: 3
        },
        {
            question: "What is the largest single source of ocean plastic pollution?",
            answers: ["Drinking straws", "Plastic bags", "Fishing gear", "Food wrappers"],
            correct: 2
        }
    ];

    const quizContainer = document.getElementById('quiz-container');
    const quizResults = document.getElementById('quiz-results');
    const questionEl = document.getElementById('question');
    const answersEl = document.getElementById('answers');
    const scoreEl = document.getElementById('score');
    const feedbackEl = document.getElementById('feedback');
    const restartButton = document.getElementById('restart-quiz');
    
    let currentQuestion = 0;
    let score = 0;

    function loadQuiz() {
        const currentQuizData = quizData[currentQuestion];
        questionEl.innerText = currentQuizData.question;
        answersEl.innerHTML = '';

        currentQuizData.answers.forEach((answer, index) => {
            const button = document.createElement('button');
            button.innerText = answer;
            button.classList.add('bg-white', 'p-4', 'rounded-lg', 'shadow-sm', 'hover:bg-emerald-100', 'transition-colors', 'duration-200');
            button.addEventListener('click', () => selectAnswer(index));
            answersEl.appendChild(button);
        });
    }

    function selectAnswer(selectedIndex) {
        if (selectedIndex === quizData[currentQuestion].correct) {
            score++;
        }

        currentQuestion++;

        if (currentQuestion < quizData.length) {
            loadQuiz();
        } else {
            showResults();
        }
    }

    function showResults() {
        quizContainer.classList.add('hidden');
        quizResults.classList.remove('hidden');

        const percentage = Math.round((score / quizData.length) * 100);
        scoreEl.innerText = `${score} / ${quizData.length} (${percentage}%)`;

        if (percentage > 75) {
            feedbackEl.innerText = "Excellent! You're a true eco-warrior.";
        } else if (percentage > 50) {
            feedbackEl.innerText = "Great job! You know a lot about protecting our planet.";
        } else {
            feedbackEl.innerText = "Good start! Keep learning about how you can help the Earth.";
        }
    }
    
    function restartQuiz() {
        currentQuestion = 0;
        score = 0;
        quizResults.classList.add('hidden');
        quizContainer.classList.remove('hidden');
        loadQuiz();
    }

    restartButton.addEventListener('click', restartQuiz);
    
    // Initial load
    if (quizContainer) {
        loadQuiz();
    }

    // Smooth scroll for nav links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            document.querySelector(this.getAttribute('href')).scrollIntoView({
                behavior: 'smooth'
            });
            // Close mobile menu on link click
            if (mobileMenu && !mobileMenu.classList.contains('hidden')) {
                 mobileMenu.classList.add('hidden');
            }
        });
    });
});
