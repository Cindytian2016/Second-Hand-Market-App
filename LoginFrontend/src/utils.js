// to communicate with backend
const domain = "https://secondhandmarket-boxntxczqq-uw.a.run.app"; // 后端地址

export const login = (credential) => {
  const loginUrl = `${domain}/auth/login`;
  return fetch(loginUrl, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(credential),
  }).then((response) => {
    if (response.status >= 300) {
      throw Error("Fail to log in");
    }

    return response.json();
  });
};

export const register = (credential) => {
  const registerUrl = `${domain}/auth/register`;
  return fetch(registerUrl, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(credential),
  }).then((response) => {
    if (response.status >= 300) {
      throw Error("Fail to register");
    }
  });
};
