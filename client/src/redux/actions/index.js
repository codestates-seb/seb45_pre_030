export const TOGGLE_FILTER_OPTION = 'TOGGLE_FILTER_OPTION';
export const ADD_FILTER_TAG = 'ADD_FILTER_TAG';
export const DELETE_FILTER_TAG = 'DELETE_FILTER_TAG';

export const toggleFilterOption = () => ({
  type: TOGGLE_FILTER_OPTION,
});

export const addFilterTag = (tag) => ({
  type: ADD_FILTER_TAG,
  payload: tag,
});

export const deleteFilterTag = (tag) => ({
  type: DELETE_FILTER_TAG,
  payload: tag,
});
