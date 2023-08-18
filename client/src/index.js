import { BrowserRouter } from 'react-router-dom';
import ReactDOM from 'react-dom/client';
import { GlobalStyle } from './style/globalStyle';
import App from './App';
import { Provider } from 'react-redux';
import store from './redux';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <GlobalStyle />
    <Provider store={store}>
      <App />
    </Provider>
  </BrowserRouter>,
);
