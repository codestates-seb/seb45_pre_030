import { Routes, Route } from 'react-router';
import Questions from './pages/Questions/Questions';
import Footer from './components/Footer/Footer';
import AskQuestion from './components/AskQuestion/AskQuestion';
import Header from './components/Header/Header';
import Login from './components/Login/Login';
import Signup from './components/Signup/Signup';
import Test from './pages/test/test';

function App() {
    return (
        <div className="App">
            <Header />
            <Routes>
                <Route path="/" element={<Questions />} />
                <Route path="/ask" element={<AskQuestion />} />
                <Route path="/login" element={<Login />} />
                <Route path="/signup" element={<Signup />} />
                <Route path="/tags" element={<Test />} />
            </Routes>
            <Footer />
        </div>
    );
}

export default App;
