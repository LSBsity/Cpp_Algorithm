import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Music[] musics = new Music[genres.length];

        for (int i = 0; i < genres.length; i++) {
            musics[i] = new Music(i, genres[i], plays[i]);
            System.out.println(musics[i].id + " " + musics[i].genres + " " + musics[i].plays);
        }

        Map<String, List<Music>> genreMap = Arrays.stream(musics)
                .collect(Collectors.groupingBy(m -> m.genres));

        Map<String, Integer> genrePlaySum = new HashMap<>();

        for (var entry : genreMap.entrySet()) {
            int sum = entry.getValue().stream().mapToInt(m -> m.plays).sum();
            genrePlaySum.put(entry.getKey(), sum);
        }

        List<String> sortedGenres = genrePlaySum.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(i -> i.getKey())
                .collect(Collectors.toList());

        List<Integer> list = new ArrayList<>();
        for (var genre : sortedGenres) {
            List<Music> musicList = genreMap.get(genre);
            musicList.sort((a, b) -> {
                if (b.plays == a.plays) return a.id - b.id;
                return b.plays - a.plays;
            });

            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                list.add(musicList.get(i).id);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    static class Music {
        int id;
        String genres;
        int plays;

        public Music(int id, String genres, int plays) {
            this.id = id;
            this.genres = genres;
            this.plays = plays;
        }
    }
}