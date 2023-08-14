import { Routes, Route } from 'react-router';
import Questions from './pages/Questions/Questions';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/questions" element={<Questions />} />
      </Routes>
    </div>
  );
}

export default App;
