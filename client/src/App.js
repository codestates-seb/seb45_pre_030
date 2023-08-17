import { Routes, Route } from 'react-router';
import Questions from './pages/Questions/Questions';
import Footer from './components/Footer/Footer';
import AskQuestion from './components/AskQuestion/AskQuestion';
import Header from './components/Header/Header';

function App() {
  return (
    <div className="App">
     <Header />
      <Routes>
        <Route path="/" element={<Questions />} />
        <Route path="/ask" element={<AskQuestion />} />
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
