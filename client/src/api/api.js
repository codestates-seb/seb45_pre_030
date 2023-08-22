export function fetchData(page, size) {
  return fetch(
    `https://09ab-39-117-8-218.ngrok-free.app/question?page=${page}&size=${size}`,
    {
      method: 'GET',
      headers: {
        Origin: 'http://localhost:3000',
      },
      credentials: 'include',
      //   mode: 'no-cors',
    },
  ).then((response) => response.json());
}
