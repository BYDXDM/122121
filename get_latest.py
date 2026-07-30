import urllib.request
import json
url = "https://search.maven.org/solrsearch/select?q=a:ffmpeg-kit-audio"
response = urllib.request.urlopen(url)
data = json.loads(response.read())
for doc in data['response']['docs']:
    print(f"{doc['g']}:{doc['a']}:{doc['latestVersion']}")
