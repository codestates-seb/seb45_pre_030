import { Routes, Route } from 'react-router';
import Questions from './pages/Questions/Questions';
import Footer from './components/Footer/Footer';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Questions />} />
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
