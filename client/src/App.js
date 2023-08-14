import { Routes, Route } from 'react-router';
import QuestionList from './pages/Questions/Questions';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/questions" element={<QuestionList />} />
      </Routes>
    </div>
  );
}

export default App;
