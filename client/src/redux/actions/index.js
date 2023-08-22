export const TOGGLE_FILTER_OPTION = 'TOGGLE_FILTER_OPTION';
export const ADD_FILTER_TAG = 'ADD_FILTER_TAG';
export const DELETE_FILTER_TAG = 'DELETE_FILTER_TAG';
export const SET_FETCHED_DATA = 'SET_FETCHED_DATA';
export const SET_CURRENT_PAGE = 'SET_CURRENT_PAGE';

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

export const setFetchedData = (data) => ({
  type: SET_FETCHED_DATA,
  payload: data,
});

export const setCurrentPage = (pageNumber) => ({
  type: SET_CURRENT_PAGE,
  payload: pageNumber,
});
