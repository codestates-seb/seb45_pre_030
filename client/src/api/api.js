const apiURL =
  'http://ec2-13-209-41-8.ap-northeast-2.compute.amazonaws.com:8080';

export function fetchQuestions(page, size) {
  return fetch(`${apiURL}/question?page=${page}&size=${size}`, {
    method: 'GET',
    headers: {
      Origin: 'http://localhost:3000',
    },
    credentials: 'include',
    //   mode: 'no-cors',
  }).then((response) => response.json());
}

export function fetchQuestion(questionId) {
  return fetch(`${apiURL}/question/${questionId}`, {
    method: 'GET',
    headers: {
      Origin: 'http://localhost:3000',
    },
    credentials: 'include',
  }).then((response) => response.json());
}
