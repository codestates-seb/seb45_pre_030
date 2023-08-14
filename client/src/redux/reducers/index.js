import { combineReducers } from 'redux';
import {
  ADD_FILTER_TAG,
  TOGGLE_FILTER_OPTION,
  DELETE_FILTER_TAG,
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

const rootReducer = combineReducers({
  isFilterOptionHidden: filterOptionReducer,
  filterTagList: filterTagReducer,
});

export default rootReducer;
