import { combineReducers } from 'redux';
import {
  ADD_FILTER_TAG,
  TOGGLE_FILTER_OPTION,
  DELETE_FILTER_TAG,
  SET_FETCHED_DATA,
  SET_CURRENT_PAGE,
  SET_FETCHED_QUESTION_DATA,
} from '../actions';

const filterOptionReducer = (state = true, action) => {
  switch (action.type) {
    case TOGGLE_FILTER_OPTION:
      return !state;
    default:
      return state;
  }
};

const filterTagReducer = (state = [], action) => {
  switch (action.type) {
    case ADD_FILTER_TAG:
      return action.payload !== '' ? [...state, action.payload] : state;
    case DELETE_FILTER_TAG:
      return state.filter((tag) => tag !== action.payload);
    default:
      return state;
  }
};

const fetchedDataReducer = (state = { data: [], pageInfo: {} }, action) => {
  switch (action.type) {
    case SET_FETCHED_DATA:
      return action.payload;
    default:
      return state;
  }
};

const currentPageReducer = (state = 1, action) => {
  switch (action.type) {
    case SET_CURRENT_PAGE:
      return action.payload;
    default:
      return state;
  }
};

const fetchedQuestionDataReducer = (
  state = { question: {}, replies: [] },
  action,
) => {
  switch (action.type) {
    case SET_FETCHED_QUESTION_DATA:
      return action.payload;
    default:
      return state;
  }
};

const rootReducer = combineReducers({
  isFilterOptionHidden: filterOptionReducer,
  filterTagList: filterTagReducer,
  fetchedData: fetchedDataReducer,
  currentPage: currentPageReducer,
  fetchedQuestionData: fetchedQuestionDataReducer,
});

export default rootReducer;
