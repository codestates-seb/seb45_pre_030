import { combineReducers } from 'redux';
import { TOGGLE_FILTER_OPTION } from '../actions';

const filterOptionReducer = (state = true, action) => {
  switch (action.type) {
    case TOGGLE_FILTER_OPTION:
      return !state;
    default:
      return state;
  }
};

const rootReducer = combineReducers({
  isFilterOptionHidden: filterOptionReducer,
});

export default rootReducer;
